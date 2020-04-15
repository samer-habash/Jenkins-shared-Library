#!/usr/bin/env groovy

def call(Map kubernetesParams) {
	kubernetes(
		cloud: kubernetesParams.cloud,
		label: kubernetesParams.label,
		containers: [
			containerTemplate(
				name: kubernetesParams.name,
				image: kubernetesParams.image,
				command: 'cat',
				ttyEnabled: 'true')
		])
	}

// // Apply on local Jenkins pipeline Job
// @Library('general-jenkins-library@master') _
// pipeline {
//     agent {
//         kubernetes-declarative-lib(
//             cloud 'kubernetes-Cluster2'
//         	label 'general-pod-label-cluster2'
//         	activeDeadlineSeconds '300'
//         	containerTemplate {
//                 name 'maven-image'
//                 image 'maven:3.3.9-jdk-8-alpine'
//         	}
//         }
//     }
//     stages {
//         stage('clone git maven') {
//             steps {
//                 container('maven-image') {
// 			        gitCo(
// 			            branch: "master",
// 			            url: "https://github.com/web3j/sample-project-maven.git"
// 			        )}
//                 }
//             }
//         }
// 	    stage('Install Maven') {
// 	        steps {
// 		        container('maven-image') {
// 			        sh 'mvn clean install'
// 			    }
// 		    }
//         }
//     }
// }