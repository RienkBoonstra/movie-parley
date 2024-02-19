1. minikube start --driver=docker (if an GUEST_DRIVER_MISMATCH error occurs then first delete the current minikube 
   cluster was probably started with a different driver. Command to delete the cluster use is: minikube delete 
2. eval $(minikube -p minikube docker-env)
3. docker build -t <image-name> . (must be down in same terminal session as wherein minikube is started. Minikube has 
   its own docker running, so you have to build the images again and again, just as many times minikube is deleted (I 
   assume))
4. kubectl apply -f deployment.yml
5. kubectl get services
6. minikube service <name-of-the-service> --url (terminal needs to be open to run it, so open another session and 
   access the url, with curl for example)

Look here for how to use ingress (haven't got it to work up to now with my code base):
https://kubernetes.io/docs/tasks/access-application-cluster/ingress-minikube/