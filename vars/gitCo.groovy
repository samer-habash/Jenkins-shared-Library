#!/usr/bin/env groovy

def call(Map gitcoParams) {
    checkout([
        $class: 'GitSCM',
        branches: [[name:  gitcoParams.branch ]],
        userRemoteConfigs: [[ url: gitcoParams.url ]]
    ])
  }

// @Library('general-jenkins-library@master') _
//
// pipeline {
//     agent any
//     stages {
//         stage('Git Checkout') {
//             steps {
//             gitCo(
//                 branch: "master",
//                 url: "https://github.com/samer-habash/-hw-14-.git"
//             )}
//          }
//     }
// }