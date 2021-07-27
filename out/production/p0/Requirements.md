# Project 0 Requirements
A Java CLI (command-line interface) or server program. Program should accept and parse command-line args, stdin (standard input), text files, web APIs, or socket/HTTP request, and produce some output to stdout (standard output), a file/SQL database, or socket/HTTP response. Programs should start simple and features should be added constantly. Your program should also be managed by a build tool (Maven), well tested, well documented, and should produce log output.

## Suggested Ideas
- Journal/note taking app
- Calculator
- To-do app
- Business/Account management system
- Bank Account program
- Password manager
- Productivity/automation tool
- (very simple) text-based game
- Text/SQL database parser
- Web API client

## Suggested development philosophy: Suffering Oriented Programming
1) Functionality - Make it possible: build a prototype without any bells or whistles, make it as fast as you can, don't care about complex architecture (OOP), don't care about many features at first, just think about what is your MVP (minimal viable product).
2) Quality - Make it beautiful: once you have your prototype, beautify it with added features, architecture changes (OOP, packages), refactor for readability, maintainibility, extensibility
3) Performance - Make it fast: consider your bottlenecks and future scalability issues, and improve what is economical at that moment.

## Requirements
### Technical Requirements
- Java 8+:
  - Java SE Libraries & features:
    - Collections API
    - Threads
    - IO: FileReader/HttpUrlConnection/Scanner/Socket
- Maven
- GitHub
- JUnit
- Persistence: File/log/SQL

### Quality Requirements
- Unit Testing
- Documentation: markdown files, javadocs comments
- Logging
- Project/Dependency Management: Maven

### Presentations
- Week 1 Friday: Propose your project
- Week 3 Wednesday: 5 minute presentation to QC
  - Personal introduction & Project quick explanation
  - Live demonstration
  - Take Questions & Answer
