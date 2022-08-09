# -*- mode: Python -*-
update_settings(suppress_unused_image_warnings=["qaware/micronaut-beer-grpc", "qaware/quarkus-beer-grpc"])

# for the Quarkus beer services
# local_resource('quarkus-beer-grpc-build', './gradlew assemble', dir='quarkus-beer-grpc',
#   deps=['./quarkus-beer-grpc/build.gradle', './quarkus-beer-grpc/src/'], labels=['Quarkus'])

# docker_build('qaware/quarkus-beer-grpc', './quarkus-beer-grpc/',
#   dockerfile='quarkus-beer-grpc/src/main/docker/Dockerfile.jvm', only=['./build/'])

# k8s_yaml(['quarkus-beer-grpc/k8s/deployment.yaml', 'quarkus-beer-grpc/k8s/service.yaml'])
# k8s_resource(workload='grpc-beer-service', port_forwards=[port_forward(19090, 9090, 'gRPC API')], labels=['Quarkus'])

# local_resource('quarkus-beer-rest-build', './gradlew assemble', dir='quarkus-beer-rest',
#   deps=['./quarkus-beer-rest/build.gradle', './quarkus-beer-rest/src/'], labels=['Quarkus'])

# docker_build('qaware/quarkus-beer-rest', './quarkus-beer-rest/',
#   dockerfile='quarkus-beer-rest/src/main/docker/Dockerfile.jvm', only=['./build/'])

# k8s_yaml(['quarkus-beer-rest/k8s/deployment.yaml', 'quarkus-beer-rest/k8s/service.yaml'])
# k8s_resource(workload='rest-beer-service', port_forwards=[port_forward(18080, 8080, 'REST API')], labels=['Quarkus'])

# for the Micronaut beer service
custom_build('qaware/micronaut-beer-grpc', 'cd micronaut-beer-grpc && ./gradlew jibDockerBuild --image $EXPECTED_REF',
  ['./micronaut-beer-grpc/build.gradle', './micronaut-beer-grpc/src/'])
k8s_yaml(['micronaut-beer-grpc/k8s/deployment.yaml', 'micronaut-beer-grpc/k8s/service.yaml'])
k8s_resource(workload='grpc-beer-service', port_forwards=[port_forward(19090, 9090, 'gRPC API')], labels=['Micronaut'])

custom_build('qaware/micronaut-beer-rest', 'cd micronaut-beer-rest && ./gradlew jibDockerBuild --image $EXPECTED_REF',
  ['./micronaut-beer-rest/build.gradle', './micronaut-beer-rest/src/'])
k8s_yaml(['micronaut-beer-rest/k8s/deployment.yaml', 'micronaut-beer-rest/k8s/service.yaml'])
k8s_resource(workload='rest-beer-service', port_forwards=[port_forward(18080, 8080, 'REST API')], labels=['Micronaut'])

# the gRPC beer Gateway
docker_build('qaware/grpc-beer-gateway', './grpc-beer-gateway/', dockerfile='grpc-beer-gateway/Dockerfile')
k8s_yaml(['grpc-beer-gateway/k8s/deployment.yaml', 'grpc-beer-gateway/k8s/service.yaml'])
k8s_resource(workload='grpc-beer-gateway', port_forwards=[port_forward(18090, 8090, 'REST API')], labels=['gRPC'])

# the gRPC beer Envoy
docker_build('qaware/grpc-beer-envoy', './grpc-beer-envoy/', dockerfile='grpc-beer-envoy/Dockerfile')
k8s_yaml(['grpc-beer-envoy/k8s/deployment.yaml', 'grpc-beer-envoy/k8s/service.yaml'])
k8s_resource(workload='grpc-beer-envoy', port_forwards=[port_forward(18091, 8091, 'gRPC Web')], labels=['gRPC'])

# the gRPC beer Nginx
docker_build('qaware/grpc-beer-nginx', './grpc-beer-nginx/', dockerfile='grpc-beer-nginx/Dockerfile')
k8s_yaml(['grpc-beer-nginx/k8s/deployment.yaml', 'grpc-beer-nginx/k8s/service.yaml'])
k8s_resource(workload='grpc-beer-nginx', port_forwards=[port_forward(18888, 8888, 'gRPC Proxy')], labels=['gRPC'])

# the gRPC beer UI
k8s_yaml(['grpc-beer-ui/k8s/deployment.yaml', 'grpc-beer-ui/k8s/service.yaml'])
k8s_resource(workload='grpc-beer-ui', port_forwards=[port_forward(16969, 6969, 'gRPC UI')], labels=['gRPC'])
