#!/bin/sh

ssh -o StrictHostKeyChecking=no deploy@deves.xdi.uevora.pt << 'ENDSSH'
  cd ./app
  export $(cat .env | xargs)
  docker login -u $CI_REGISTRY_USER -p $CI_REGISTRY_PASSWORD $CI_REGISTRY
  sudo docker-compose up -d
ENDSSH