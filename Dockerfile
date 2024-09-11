FROM openjdk:17

WORKDIR /App-LB-RoundRobin/bin

ENV PORT 6000

COPY /target/classes /App-LB-RoundRobin/bin/classes

CMD ["java","-cp","./classes:./dependency/*","arep.lab4.roundrobin.RoundRobinApplication"]