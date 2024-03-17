# k8sonedemoone
SpringBootK8sOne

```


Cloud Shell Editor
------------------
project ID : fresh-ember-414917

jdkcolt@cloudshell:~$ gcloud config set project fresh-ember-414917
Updated property [core/project].
jdkcolt@cloudshell:~ (fresh-ember-414917)$ 

mkdir codebase
cd codebase
git clone https://github.com/thanooj/k8sonedemoone.git -b main 
cd k8sonedemoone
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ ls -ltr
total 52
drwxr-xr-x 4 jdkcolt jdkcolt  4096 Mar  9 10:28 src
-rw-r--r-- 1 jdkcolt jdkcolt    33 Mar  9 10:28 README.md
-rw-r--r-- 1 jdkcolt jdkcolt  1369 Mar  9 10:28 pom.xml
-rw-r--r-- 1 jdkcolt jdkcolt  6607 Mar  9 10:28 mvnw.cmd
-rw-r--r-- 1 jdkcolt jdkcolt 10069 Mar  9 10:28 mvnw
-rw-r--r-- 1 jdkcolt jdkcolt   429 Mar  9 10:28 HELP.md
-rw-r--r-- 1 jdkcolt jdkcolt   116 Mar  9 11:03 dockerfile
drwxr-xr-x 8 jdkcolt jdkcolt  4096 Mar  9 11:05 target
-rw-r--r-- 1 jdkcolt jdkcolt   476 Mar  9 18:11 deployment.yaml
-rw-r--r-- 1 jdkcolt jdkcolt   389 Mar  9 19:07 service.yaml
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$


jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ cat dockerfile
FROM openjdk:17-alpine
COPY ./target/k8sonedemoone-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 

* build local docker image
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ docker build -f dockerfile -t k8sonerepo:v1 .
[+] Building 0.2s (7/7) FINISHED                                                                                                                           docker:default
 => [internal] load build definition from dockerfile                                                                                                                 0.0s
 => => transferring dockerfile: 153B                                                                                                                                 0.0s
 => [internal] load metadata for docker.io/library/openjdk:17-alpine                                                                                                 0.1s
 => [internal] load .dockerignore                                                                                                                                    0.0s
 => => transferring context: 2B                                                                                                                                      0.0s
 => [internal] load build context                                                                                                                                    0.0s
 => => transferring context: 89B                                                                                                                                     0.0s
 => [1/2] FROM docker.io/library/openjdk:17-alpine@sha256:4b6abae565492dbe9e7a894137c966a7485154238902f2f25e9dbd9784383d81                                           0.0s
 => CACHED [2/2] COPY ./target/k8sonedemoone-0.0.1-SNAPSHOT.jar app.jar                                                                                              0.0s
 => exporting to image                                                                                                                                               0.0s
 => => exporting layers                                                                                                                                              0.0s
 => => writing image sha256:e094aab494f0a7d6980d895643f38b8e61d5977ec2771ce3896f1807bbb7f949                                                                         0.0s
 => => naming to docker.io/library/k8sonerepo:v1                                                                                                                     0.0s
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ docker images
REPOSITORY   TAG       IMAGE ID       CREATED          SIZE
k8sonerepo   v1        e094aab494f0   51 minutes ago   345MB





Artifact Repository
-------------------
* create a Artifact Repository - 'k8sonedemoone' : us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone
* us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage

jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ docker tag e094aab494f0 us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ docker push us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage
Using default tag: latest
The push refers to repository [us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage]
187bc19e5a70: Pushed 
34f7184834b2: Pushed 
5836ece05bfd: Pushed 
72e830a4dff5: Pushed 
latest: digest: sha256:215bfee949b75efaa2c1f2c55c90a442ae705a4c2863ec96a179e43a64983a8d size: 1163
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 

* v1
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ docker tag e094aab494f0 us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage:v1
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ docker push us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage:v1


jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ docker images
REPOSITORY                                                                TAG       IMAGE ID       CREATED             SIZE
k8sonerepo                                                                v1        e094aab494f0   About an hour ago   345MB
us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage   latest    e094aab494f0   About an hour ago   345MB
us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage   v1        e094aab494f0   About an hour ago   345MB
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 



* pull image
gcloud auth configure-docker us-central1-docker.pkg.dev
docker pull us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage:latest
docker pull us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage:v1


jdkcolt@cloudshell:~ (fresh-ember-414917)$ docker images 
REPOSITORY                                                                TAG       IMAGE ID       CREATED        SIZE
us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage   latest    e094aab494f0   13 hours ago   345MB
us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage   v1        e094aab494f0   13 hours ago   345MB
jdkcolt@cloudshell:~ (fresh-ember-414917)$ 





Kubernaties Engine::
--------------------
cluster-1 - create a new kubernates cluster 
Connect to the cluster:
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ gcloud container clusters get-credentials cluster-1 --zone us-central1-c --project fresh-ember-414917
Fetching cluster endpoint and auth data.
kubeconfig entry generated for cluster-1.


jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ cat deployment.yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: k8sonespringbootapp-deploy
spec:
  replicas: 3
  selector:
    matchLabels:
      app: k8sonespringbootapp
  template:
    metadata:
      labels:
        app: k8sonespringbootapp
    spec:
      containers:
        - name: k8sonespringbootapp
          image: us-central1-docker.pkg.dev/fresh-ember-414917/k8sonedemoone/k8soneimage:v1
          imagePullPolicy: Always
          ports:
            - containerPort: 8080
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 

jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ cat service.yaml 
apiVersion: v1
kind: Service
metadata:
  name: k8sonespringbootapp-service
spec:
  selector:
    app: k8sonespringbootapp
  ports:
    - protocol: TCP
      port: 8080
      targetPort: 8080
  type: LoadBalancer
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 



jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl apply -f deployment.yaml
deployment.apps/k8sonespringbootapp-deploy created
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl get deployments
NAME                         READY   UP-TO-DATE   AVAILABLE   AGE
k8sonespringbootapp-deploy   3/3     3            3           31s
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl get pods
NAME                                          READY   STATUS    RESTARTS   AGE
k8sonespringbootapp-deploy-7b4bb4c87b-95hfj   1/1     Running   0          36s
k8sonespringbootapp-deploy-7b4bb4c87b-blnx6   1/1     Running   0          36s
k8sonespringbootapp-deploy-7b4bb4c87b-qfwgl   1/1     Running   0          36s
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 



jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl logs k8sonespringbootapp-deploy-7b4bb4c87b-95hfj

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.3)

2024-03-10T04:51:59.152Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : Starting K8sonedemooneApplication v0.0.1-SNAPSHOT using Java 17-ea with PID 1 (/app.jar started by root in /)
2024-03-10T04:51:59.157Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : No active profile set, falling back to 1 default profile: "default"
2024-03-10T04:52:00.900Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-03-10T04:52:00.921Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-03-10T04:52:00.922Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.19]
2024-03-10T04:52:01.128Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-03-10T04:52:01.130Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1871 ms
2024-03-10T04:52:02.195Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-03-10T04:52:02.228Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : Started K8sonedemooneApplication in 3.913 seconds (process running for 4.909)
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl logs k8sonespringbootapp-deploy-7b4bb4c87b-blnx6

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.3)

2024-03-10T04:51:59.012Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : Starting K8sonedemooneApplication v0.0.1-SNAPSHOT using Java 17-ea with PID 1 (/app.jar started by root in /)
2024-03-10T04:51:59.018Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : No active profile set, falling back to 1 default profile: "default"
2024-03-10T04:52:01.215Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-03-10T04:52:01.238Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-03-10T04:52:01.239Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.19]
2024-03-10T04:52:01.515Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-03-10T04:52:01.519Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2345 ms
2024-03-10T04:52:02.982Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-03-10T04:52:03.035Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : Started K8sonedemooneApplication in 4.949 seconds (process running for 6.205)
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl logs k8sonespringbootapp-deploy-7b4bb4c87b-qfwgl

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.3)

2024-03-10T04:51:57.692Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : Starting K8sonedemooneApplication v0.0.1-SNAPSHOT using Java 17-ea with PID 1 (/app.jar started by root in /)
2024-03-10T04:51:57.697Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : No active profile set, falling back to 1 default profile: "default"
2024-03-10T04:51:59.528Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-03-10T04:51:59.552Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-03-10T04:51:59.553Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.19]
2024-03-10T04:51:59.732Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-03-10T04:51:59.735Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1924 ms
2024-03-10T04:52:00.892Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-03-10T04:52:00.917Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : Started K8sonedemooneApplication in 3.926 seconds (process running for 5.028)
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 



jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl apply -f service.yaml
service/k8sonespringbootapp-service created
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl get svc
NAME                          TYPE           CLUSTER-IP   EXTERNAL-IP    PORT(S)          AGE
k8sonespringbootapp-service   LoadBalancer   10.8.3.196   35.224.134.2   8080:32151/TCP   47s
kubernetes                    ClusterIP      10.8.0.1     <none>         443/TCP          54m
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 


jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl describe svc k8sonespringbootapp-service
Name:                     k8sonespringbootapp-service
Namespace:                default
Labels:                   <none>
Annotations:              cloud.google.com/neg: {"ingress":true}
Selector:                 app=k8sonespringbootapp
Type:                     LoadBalancer
IP Family Policy:         SingleStack
IP Families:              IPv4
IP:                       10.8.3.196
IPs:                      10.8.3.196
LoadBalancer Ingress:     35.224.134.2
Port:                     <unset>  8080/TCP
TargetPort:               8080/TCP
NodePort:                 <unset>  32151/TCP
Endpoints:                10.4.0.6:8080,10.4.1.9:8080,10.4.2.12:8080
Session Affinity:         None
External Traffic Policy:  Cluster
Events:
  Type    Reason                Age   From                Message
  ----    ------                ----  ----                -------
  Normal  EnsuringLoadBalancer  88s   service-controller  Ensuring load balancer
  Normal  EnsuredLoadBalancer   50s   service-controller  Ensured load balancer
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 




jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl get nodes -o wide
NAME                                       STATUS   ROLES    AGE   VERSION               INTERNAL-IP   EXTERNAL-IP      OS-IMAGE                             KERNEL-VERSION   CONTAINER-RUNTIME
gke-cluster-1-default-pool-76afc15b-8319   Ready    <none>   54m   v1.27.8-gke.1067004   10.128.0.15   34.70.191.241    Container-Optimized OS from Google   5.15.133+        containerd://1.7.10
gke-cluster-1-default-pool-76afc15b-h92v   Ready    <none>   54m   v1.27.8-gke.1067004   10.128.0.13   34.123.118.202   Container-Optimized OS from Google   5.15.133+        containerd://1.7.10
gke-cluster-1-default-pool-76afc15b-ncn0   Ready    <none>   54m   v1.27.8-gke.1067004   10.128.0.14   34.122.112.65    Container-Optimized OS from Google   5.15.133+        containerd://1.7.10
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl get pods -o wide
NAME                                          READY   STATUS    RESTARTS   AGE     IP          NODE                                       NOMINATED NODE   READINESS GATES
k8sonespringbootapp-deploy-7b4bb4c87b-95hfj   1/1     Running   0          7m21s   10.4.1.9    gke-cluster-1-default-pool-76afc15b-ncn0   <none>           <none>
k8sonespringbootapp-deploy-7b4bb4c87b-blnx6   1/1     Running   0          7m21s   10.4.2.12   gke-cluster-1-default-pool-76afc15b-8319   <none>           <none>
k8sonespringbootapp-deploy-7b4bb4c87b-qfwgl   1/1     Running   0          7m21s   10.4.0.6    gke-cluster-1-default-pool-76afc15b-h92v   <none>           <none>
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 






REST API - http://<Service-LoadBalancer-Ingress><TargetPort>/endpoint
http://35.226.75.37:8081/greet/ram
http://35.226.75.37:8081/books




jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl logs -l app=k8sonespringbootapp

2024-03-10T04:51:59.152Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : Starting K8sonedemooneApplication v0.0.1-SNAPSHOT using Java 17-ea with PID 1 (/app.jar started by root in /)
2024-03-10T04:51:59.157Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : No active profile set, falling back to 1 default profile: "default"
2024-03-10T04:52:00.900Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-03-10T04:52:00.921Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-03-10T04:52:00.922Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.19]
2024-03-10T04:52:01.128Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-03-10T04:52:01.130Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1871 ms
2024-03-10T04:52:02.195Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-03-10T04:52:02.228Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : Started K8sonedemooneApplication in 3.913 seconds (process running for 4.909)
2024-03-10T04:52:01.238Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-03-10T04:52:01.239Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.19]
2024-03-10T04:52:01.515Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-03-10T04:52:01.519Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2345 ms
2024-03-10T04:52:02.982Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-03-10T04:52:03.035Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : Started K8sonedemooneApplication in 4.949 seconds (process running for 6.205)
2024-03-10T04:59:36.317Z  INFO 1 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-03-10T04:59:36.318Z  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-03-10T04:59:36.321Z  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
2024-03-10T04:59:44.226Z  INFO 1 --- [nio-8080-exec-3] c.k.k.K8sonedemooneApplication           : greet -  Hello, ram!!

2024-03-10T04:51:57.692Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : Starting K8sonedemooneApplication v0.0.1-SNAPSHOT using Java 17-ea with PID 1 (/app.jar started by root in /)
2024-03-10T04:51:57.697Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : No active profile set, falling back to 1 default profile: "default"
2024-03-10T04:51:59.528Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-03-10T04:51:59.552Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-03-10T04:51:59.553Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.19]
2024-03-10T04:51:59.732Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-03-10T04:51:59.735Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1924 ms
2024-03-10T04:52:00.892Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-03-10T04:52:00.917Z  INFO 1 --- [           main] c.k.k.K8sonedemooneApplication           : Started K8sonedemooneApplication in 3.926 seconds (process running for 5.028)
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$



jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl get nodes
NAME                                       STATUS   ROLES    AGE     VERSION
gke-cluster-1-default-pool-e8181dc8-bh6h   Ready    <none>   7m29s   v1.27.8-gke.1067004
gke-cluster-1-default-pool-e8181dc8-dkk9   Ready    <none>   7m28s   v1.27.8-gke.1067004
gke-cluster-1-default-pool-e8181dc8-hjsm   Ready    <none>   7m29s   v1.27.8-gke.1067004


jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl apply -f mysql-secrets.yaml
secret/mysql-secrets created
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl apply -f mysql-configMap.yaml 
configmap/db-config created
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 

jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl get configmap
NAME               DATA   AGE
db-config          2      4m30s
kube-root-ca.crt   1      11m
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl get secrets
NAME            TYPE     DATA   AGE
mysql-secrets   Opaque   2      5m15s
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 

jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl apply -f db_deployment_service.yaml
persistentvolumeclaim/mysql-pv-claim created
deployment.apps/mysql created
service/mysql created

jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl get pods
NAME                     READY   STATUS    RESTARTS   AGE
mysql-7b98d5ffc7-48bzq   1/1     Running   0          4m24s

# MySQL startup logs:
---------------------
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl logs mysql-7b98d5ffc7-48bzq
2024-03-10 16:25:43+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.3.0-1.el8 started.
2024-03-10 16:25:43+00:00 [Note] [Entrypoint]: Switching to dedicated user 'mysql'
2024-03-10 16:25:43+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.3.0-1.el8 started.
2024-03-10 16:25:43+00:00 [Note] [Entrypoint]: Initializing database files
2024-03-10T16:25:43.747343Z 0 [System] [MY-015017] [Server] MySQL Server Initialization - start.
2024-03-10T16:25:43.749726Z 0 [System] [MY-013169] [Server] /usr/sbin/mysqld (mysqld 8.3.0) initializing of server in progress as process 80
2024-03-10T16:25:43.759561Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
2024-03-10T16:25:44.782137Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
2024-03-10T16:25:46.590951Z 6 [Warning] [MY-010453] [Server] root@localhost is created with an empty password ! Please consider switching off the --initialize-insecure option.
2024-03-10T16:25:51.491629Z 0 [System] [MY-015018] [Server] MySQL Server Initialization - end.
2024-03-10 16:25:51+00:00 [Note] [Entrypoint]: Database files initialized
2024-03-10 16:25:51+00:00 [Note] [Entrypoint]: Starting temporary server
2024-03-10T16:25:51.525880Z 0 [System] [MY-015015] [Server] MySQL Server - start.
2024-03-10T16:25:51.852819Z 0 [System] [MY-010116] [Server] /usr/sbin/mysqld (mysqld 8.3.0) starting as process 122
2024-03-10T16:25:51.872497Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
2024-03-10T16:25:52.204478Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
2024-03-10T16:25:52.509135Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
2024-03-10T16:25:52.509184Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
2024-03-10T16:25:52.533221Z 0 [Warning] [MY-011810] [Server] Insecure configuration for --pid-file: Location '/var/run/mysqld' in the path is accessible to all OS users. Consider choosing a different directory.
2024-03-10T16:25:52.555067Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Socket: /var/run/mysqld/mysqlx.sock
2024-03-10T16:25:52.555302Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.3.0'  socket: '/var/run/mysqld/mysqld.sock'  port: 0  MySQL Community Server - GPL.
2024-03-10 16:25:52+00:00 [Note] [Entrypoint]: Temporary server started.
'/var/lib/mysql/mysql.sock' -> '/var/run/mysqld/mysqld.sock'
Warning: Unable to load '/usr/share/zoneinfo/iso3166.tab' as time zone. Skipping it.
Warning: Unable to load '/usr/share/zoneinfo/leap-seconds.list' as time zone. Skipping it.
Warning: Unable to load '/usr/share/zoneinfo/leapseconds' as time zone. Skipping it.
Warning: Unable to load '/usr/share/zoneinfo/tzdata.zi' as time zone. Skipping it.
Warning: Unable to load '/usr/share/zoneinfo/zone.tab' as time zone. Skipping it.
Warning: Unable to load '/usr/share/zoneinfo/zone1970.tab' as time zone. Skipping it.
2024-03-10 16:25:55+00:00 [Note] [Entrypoint]: Creating database mydb

2024-03-10 16:25:55+00:00 [Note] [Entrypoint]: Stopping temporary server
2024-03-10T16:25:55.980465Z 11 [System] [MY-013172] [Server] Received SHUTDOWN from user root. Shutting down mysqld (Version: 8.3.0).
2024-03-10T16:25:57.372511Z 0 [System] [MY-010910] [Server] /usr/sbin/mysqld: Shutdown complete (mysqld 8.3.0)  MySQL Community Server - GPL.
2024-03-10T16:25:57.372544Z 0 [System] [MY-015016] [Server] MySQL Server - end.
2024-03-10 16:25:57+00:00 [Note] [Entrypoint]: Temporary server stopped

2024-03-10 16:25:57+00:00 [Note] [Entrypoint]: MySQL init process done. Ready for start up.

2024-03-10T16:25:57.999707Z 0 [System] [MY-015015] [Server] MySQL Server - start.
2024-03-10T16:25:58.315492Z 0 [System] [MY-010116] [Server] /usr/sbin/mysqld (mysqld 8.3.0) starting as process 1
2024-03-10T16:25:58.324996Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
2024-03-10T16:25:58.685177Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
2024-03-10T16:25:58.958275Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
2024-03-10T16:25:58.958334Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
2024-03-10T16:25:58.982385Z 0 [Warning] [MY-011810] [Server] Insecure configuration for --pid-file: Location '/var/run/mysqld' in the path is accessible to all OS users. Consider choosing a different directory.
2024-03-10T16:25:59.015437Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060, socket: /var/run/mysqld/mysqlx.sock
2024-03-10T16:25:59.015524Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.3.0'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.
jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ 




jdkcolt@cloudshell:~/codebase/k8sonedemoone (fresh-ember-414917)$ kubectl exec -it mysql-7b98d5ffc7-48bzq -- bin/bash
bash-4.4# mysql -u root -h mysql -p
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 8
Server version: 8.3.0 MySQL Community Server - GPL

Copyright (c) 2000, 2024, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mydb               |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.00 sec)

mysql> use mydb;
Database changed
mysql> show tables;
Empty set (0.00 sec)

mysql> select * from book;
+--------+--------------+----+--------+
| price  | publish_date | id | title  |
+--------+--------------+----+--------+
|  49.99 | 2023-04-01   |  1 | Book E |
| 109.22 | 2022-05-02   |  2 | Book C |
+--------+--------------+----+--------+
2 rows in set (0.00 sec)


GET API:
-------
curl -X GET -H 'Content-Type: application/json' -i 'http://35.226.75.37:8081/books'
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sun, 17 Mar 2024 17:09:46 GMT

[{"id":1,"title":"Book E","price":49.99,"publishDate":"2023-04-01"}]


POST API:
--------
curl -X POST -H 'Content-Type: application/json' -i 'http://35.226.75.37:8081/books' --data '{"title":"Book C","price":109.22,"publishDate":"2022-05-02"}'
{"title":"Book C","price":109.22,"publishDate":"2022-05-02"}'
HTTP/1.1 201 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sun, 17 Mar 2024 17:12:21 GMT

{"id":2,"title":"Book C","price":109.22,"publishDate":"2022-05-02"}






kubectl delete deployments k8sonespringbootapp-deploy
kubectl delete services k8sonespringbootapp-service


```
