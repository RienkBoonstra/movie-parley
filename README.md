# Docker (compose)
There is a docker compose.yml in the support/docker_compose directory which contains (mocks of) all external services the 
movieparley-backend depends on. Right it only contains a mongodb image. 
If you run movieparley-backend locally it will connect automatically to mongodb if you started docker compose.yml.
If you run movieparley-backend locally, but from a docker container be sure to connect the container to the docker 
network defined in the compose.yml and supply the MONGODB_HOSTNAME environment variable, like so:
```docker run --rm --network movie-parley-network -e MONGODB_HOSTNAME=mongodb <image-name>.```

