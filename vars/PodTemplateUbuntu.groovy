#!/usr/bin/env groovy

// I see a lot of people do not define Pod Labels in configure Cloud settings in Jenkins
// They just define it as random label like below:
//                                               def podLabel = "worker-${UUID.randomUUID()}"

def call(String PodLabel, code) {
	podTemplate(
		cloud: 'kubernetes-Cluster1'
		label: PodLabel
		name: PodLabel
		containers: [
			containerTemplate(
				name: ubuntu-image
				image: ubuntu:bionic
				command: 'cat'
				tty: 'true')
		]) {
		code()
	}
}