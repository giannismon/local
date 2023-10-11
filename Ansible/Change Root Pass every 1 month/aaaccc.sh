#!/bin/bash
date1=$(date +"%m")
x="root"$date1
ansible-playbook play.yml -e root_password=$x
