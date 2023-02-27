FROM envoyproxy/envoy:v1.17.0
EXPOSE 8091
COPY envoy.yaml /etc/envoy/envoy.yaml
CMD ["/usr/local/bin/envoy", "-c", "/etc/envoy/envoy.yaml", "-l", "trace", "--log-path", "/tmp/envoy_info.log"]