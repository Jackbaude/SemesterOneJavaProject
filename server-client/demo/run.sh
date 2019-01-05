#!/bin/bash
for i in `seq 1 5`; do
	sudo virsh start clone$i && sleep 10;
done
