module.exports = function follow(api, rootPath, relArray) {
	const root = api({
		method: 'GET',
		path: rootPath
	});

	return relArray.reduce(function(rt, arrayItem) {
		const rel = typeof arrayItem === 'string' ? arrayItem : arrayItem.rel;
		return traverseNext(rt, rel, arrayItem);
	}, rt);

	function traverseNext (rt, rel, arrayItem) {
		return rt.then(function (response) {
			if (hasEmbeddedRel(response.entity, rel)) {
				return response.entity._embedded[rel];
			}

			if(!response.entity._links) {
				return [];
			}

			if (typeof arrayItem === 'string') {
				return api({
					method: 'GET',
					path: response.entity._links[rel].href
				});
			} else {
				return api({
					method: 'GET',
					path: response.entity._links[rel].href,
					params: arrayItem.params
				});
			}
		});
	}

	function hasEmbeddedRel (entity, rel) {
		return entity._embedded && entity._embedded.hasOwnProperty(rel);
	}
};
