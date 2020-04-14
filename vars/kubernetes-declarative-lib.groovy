#!/usr/bin/env groovy

def call(Map kubernetesParams, code) {
	kubernetes(
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
