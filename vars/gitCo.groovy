#!/usr/bin/env groovy

def call(Map gitcoParams) {
    checkout([
        $class: 'GitSCM',
        branches: [[name:  gitcoParams.branch ]],
        userRemoteConfigs: [[ url: gitcoParams.url ]]
    ])
  }


// // Checkout git repo for maven
// @Library('general-jenkins-library@master') _
//
// pipeline {
//     agent any
//     stages {
//         stage('Git Checkout Maven') {
//             steps {
//             gitCo(
//                 branch: "master",
//                 url: "https://github.com/web3j/sample-project-maven"
//             )}
//          stage('Build Maven') {
//             PodTemplateMaven('general-pod-label-cluster1')
//                 node('general-pod-label-cluster1') {
//         		    stage('Build Maven Release') {
//         		        container('maven-image') {
//         		            sh "mvn clean install"
//         		        }
//         			}
//         		}
//         	}
//         }
//     }
// }