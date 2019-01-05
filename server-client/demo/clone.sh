#!bin/bash
for i in `seq 1 3`; do 
	sudo virt-clone --auto-clone --original beavermaster -n clone$i; 
done
