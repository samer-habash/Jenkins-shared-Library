#!/usr/bin/env groovy

def call(Map podParams, code) {
	podTemplate(
		cloud: podParams.cloud,
		label: podParams.label,
		containers: [
			containerTemplate(
				name: podParams.name,
				image: podParams.image,
				command: 'cat',
				ttyEnabled: 'true')
		])
	}



// Local Jenkins Apply : # This took me a while to think how to build it best
// @Library('general-jenkins-library@master') _
//
// pipeline {
//     agent any
//     stages {
//         stage('Creating Pod') {
//             steps {
//             PodTemplateGeneral(
//                 cloud: "kubernetes-Cluster1",
//                 label: "general-pod-label-cluster1",
//                 name: "ubuntu-image",
//                 image: "ubuntu:bionic"
//                 )}
//                 {
//                     // Script or commands to apply on the image
//                     sh 'cat /etc/*-release'
//                 }
//         }
//     }
// }
