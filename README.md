# k8sonedemoone
SpringBootK8sOne




Cloud Shell Editor
------------------
project ID : fresh-ember-414917

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




http://35.224.134.2:8080/greet/ram



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
