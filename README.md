# Sleep Servlet

A JAX-RS resource that can simulate different response times.

# Build

mvn package

# Run

'''
java -jar sleep-servlet-1.0-SNAPSHOT.jar
'''

# Consume

Sleep using default values:
```
curl http://localhost:8080/sleep -> echo: OK, sleep time: 100
```

Sleep for 1 second:
```
curl http://localhost:8080/sleep?millis=1000 -> echo: OK, sleep time: 1000
```

Sleep and echo custom response:
```
curl -H "X-Echo: test" http://localhost:8080/sleep?millis=1000 -> echo: test, sleep time: 1000
```

