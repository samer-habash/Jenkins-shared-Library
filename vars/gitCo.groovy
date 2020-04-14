#!/usr/bin/env groovy

def call(Map gitcoParams) {
    checkout([
        $class: 'GitSCM',
        branches: [[name:  gitcoParams.branch ]],
        userRemoteConfigs: [[ url: gitcoParams.url ]]
    ])
  }

// @Library('jenkins-library@master')
//
// pipeline {
//     agent any
//     stages {
//         stage('Git Checkout') {
//             steps {
//             gitCheckout(
//                 branch: "master",
//                 url: "https://github.com/spring-projects/spring-petclinic.git"
//             )
//             }
//          }
//     }
// }