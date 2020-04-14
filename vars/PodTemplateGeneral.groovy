#!/usr/bin/env groovy

def call(Map values, code) {
	podTemplate(
		cloud: values.cloud,
		label: values.label,
		containers: [
			containerTemplate(
				name: values.name,
				image: values.image,
				command: 'cat',
				ttyEnabled: 'true')
		]) {
		node(values.label) {
		    stage('Building Container') {
		        container(values.name) {
		           code()
		        }
		    }
		}
	}
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
