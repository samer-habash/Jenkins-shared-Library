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

// Same as PodTemplateUbuntu.groovy file , just change the image name inside the container