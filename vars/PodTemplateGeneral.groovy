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
		code()
	}
}

