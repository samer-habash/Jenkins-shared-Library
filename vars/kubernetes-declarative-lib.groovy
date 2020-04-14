#!/usr/bin/env groovy

def call(Map kubernetesParams, code) {
	kubernetes(
		cloud: kubernetesParams.cloud,
		label: kubernetesParams.label,
		containers: [
			containerTemplate(
				name: kubernetesParams.name,
				image: kubernetesParams.image,
				command: 'cat',
				ttyEnabled: 'true')
		]) {
		node(values.label) {
		    stage('Building Container') {
		        container(kubernetesParams.name) {
		           code()
		        }
		    }
		}
	}
}
