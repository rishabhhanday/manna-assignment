oc new-build java --name=manna-assignment --binary=true
gradlew build
oc start-build bc/manna-assignment --from-file=build/libs/assignment-0.0.1-SNAPSHOT.jar --follow
oc apply -f deploy/deploy.yaml
oc scale -f deploy/deploy.yaml --replicas=0
oc scale -f deploy/deploy.yaml --replicas=1
oc apply -f deploy/cluster-ip.yaml
oc expose -f deploy/cluster-ip.yaml