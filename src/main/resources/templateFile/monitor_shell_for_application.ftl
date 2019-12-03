#!/bin/bash
set -eu
pidfile="${pidFilePath}"
command="${command}"

function kill_app(){
kill $(cat $pidfile)
exit 0
}
trap "kill_app" SIGINT SIGTERM

su ${user} -s $command

sleep 5

while [ -f $pidfile ] && kill -0 $(cat $pidfile) ; do
sleep 0.5
done
exit 1000