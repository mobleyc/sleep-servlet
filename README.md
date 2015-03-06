# Sleep Servlet

A JAX-RS resource that can simulate different response times.

# Build

mvn package

# Examples

Sleep using default values:
```
curl http://localhost:8080/sleep
```

Sleep for 1 second:
```
curl http://localhost:8080/sleep?millis=1000
```

Sleep and echo custom response:
```
curl -H "X-Echo: test" http://localhost:8080/sleep?millis=1000
```

