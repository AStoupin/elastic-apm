java -javaagent:elastic-apm-agent-1.3.1-20190120.093944-10.jar  -Delastic.apm.service_name=my-soap -Delastic.apm.application_packages=ru.cetelem -Delastic.apm.enable_log_correlation=true -Delastic.apm.server_urls=http://localhost:8200 -jar d:\Work\workspaces\elastic-apm\http-test-ws\target\http-test-ws-0.0.1-SNAPSHOT.jar 