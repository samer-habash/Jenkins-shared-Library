#!/usr/bin/env groovy

def call(String PodLabel, code) {
	podTemplate(
		cloud: 'kubernetes-Cluster2',
		label: 'general-pod-label-cluster2',
		containers: [
			containerTemplate(
				name: maven-image,
				image: maven:3.3.9-jdk-8-alpine,
				command: 'cat',
				tty: 'true')
		]) {
		code()
	}
}