sudo sysctl -w vm.max_map_count=262144
docker-compose up --build

http://localhost:9200
http://localhost:9200/_cluster/health

http://localhost:9000/#/overview?host=http:%2F%2Fes_master:9200

docker-compose scale elastic-slave=2


http://localhost:8080/actuator/health