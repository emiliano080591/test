# Ejemplo de consumer y producer con Java para Apache Kafka

### CORRER ZOOKEEPER Y KAFKA CON DOCKER
```shell
$ docker-compose -f docker-compose.yml up -d
```

### EJECUTAR TERMINAL DE KAFKA
```shell
$ docker exec -it kafka /bin/sh
```

### Crear nuevo topico
```shell
$ kafka-topics.sh --create --topic test-topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4
```

### Describir topico
```shell
$ kafka-topics.sh --describe --topic test-topic --bootstrap-server localhost:9092
```

### Listar topicos
```shell
$ kafka-topics.sh --list --bootstrap-server localhost:9092
```

### Unirse como consumidor a un topico
```shell
$ kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic nombre_topico --group nombre_grupo
```

### Crear productor en un topico
```shell
$ kafka-console-producer.sh --broker-list localhost:9092 --topic nombre_topico
```