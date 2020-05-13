#!/bin/sh

ssh -o StrictHostKeyChecking=no deploy@deves.xdi.uevora.pt << 'ENDSSH'
  cd ./app
  sudo docker login -u $CI_REGISTRY_USER -p $CI_REGISTRY_PASSWORD $CI_REGISTRY
  sudo docker-compose -f docker-compose.prod.yml up -d
ENDSSH