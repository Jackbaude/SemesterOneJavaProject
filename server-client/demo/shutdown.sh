#!/bin/bash
sudo virsh list | grep clone | awk '{print $2}' | xargs -I {} sudo virsh destroy {}
