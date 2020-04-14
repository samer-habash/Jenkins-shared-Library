#!/usr/bin/env groovy

def call(String PodLabel, code) {
	podTemplate(
		cloud: 'kubernetes-Cluster2',
		label: PodLabel,
		containers: [
			containerTemplate(
				name: maven-image,
				image: maven:3.3.9-jdk-8-alpine,
				command: 'cat',
				ttyEnabled: 'true')
		]) {
		code()
	}
}

//Applies in local jenkins
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
