#!/usr/bin/env groovy

// I see a lot of people do not define Pod Labels in configure Cloud settings in Jenkins
// They just define it as random label like below:
//                                               def podLabel = "worker-${UUID.randomUUID()}"

def call(Map params, code) {
	podTemplate(
		cloud: params.Cloud,
		label: params.Label,
		containers: [
			containerTemplate(
				name: params.Name,
				image: params.Image,
				command: 'cat',
				tty: 'true')
		]) {
		code()
	}
}

// @Library('General-Shared-Library@master')
//
// PodTemplateUbuntu(
//     Cloud: 'kubernetes-Cluster1'
//     Label: 'general-pod-label-cluster1'
//     Name: 'ubuntu-image'
//     Image: 'ubuntu:bionic')
//     {
//     node('general-pod-label-cluster1') {
// 		stage('Check Ubuntu Release') {
// 		    container('ubuntu-image') {
// 		        sh "cat /etc/*-release"
// 			}
// 		}
// 	}
// }