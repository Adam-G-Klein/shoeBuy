# shoeBuy
### Alright team here's how this works
- first you clone it. yuh.
- Then you run `./mvnw spring-boot:run`. This will probably error, keep reading.
- You might run into issues with it not finding your JAVA_HOME or M2_HOME. These need to point to the place where your jdk are and the place on your machine [this](https://maven.apache.org/download.cgi) is located (respectively). Here's a screencap of my environment variables:
[Env Variables](readmefiles/env.png)
- You may also run into issues with the `./mnvw` script not finding your mvn binary file, you'll have to add it to your path: [My Path](readmefiles/path.png)
- You can find out if your system can find the mvn binary file by running `mvn -v`. If a bunch of version information pops up, you're gucci. If not, it still can't find it :( There's a lotta reasons this might happen. I'd be happy to help ya troubleshoot if it's needed.
- When `./mvnw spring-boot:run` works, you'll see the Spring ascii art when you run it. You should be able to visit `http://localhost:8080` and see a page served there.

### Random Troubleshooting

- The warning about skipping an optional dependency and the single empty error msg that gets logged during startup is expected behavior.
- If you run into an error that says the port is already in use when trying to run the server, run ` netstat -ano | findstr 8080` to find the process id that is hogging the port, and then `taskkill /F /PID <Process ID>` to kill it
- If you run into weird git crap where the `src/main/resources/static/built` directory keeps tracking changes so you can't change branches [this is a temporary fix](readmefiles/gitfix.png). This should not happen if you're on master, or have merged from master after our first setup sesh, please let me know if it does.

### Now that you're set up...

- [Here's a pretty cool video on Spring Boot](https://www.youtube.com/watch?v=sbPSjI4tt10), you can skip the groovy stuff and start at like 4:45, the relevant bits are done by about 45:00. Really cool seeing the package built step by step. Please Please let me know if I can help explain anything in there. 
- [Here's the tutorial the package is based on](https://spring.io/guides/tutorials/react-and-spring-data-rest/) Did I read the whole thing? Hell no. But if you cntrl-f a class that's doing something confusing, it'll probably have a pretty good explanation of what's going on.
