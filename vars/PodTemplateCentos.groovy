#!/usr/bin/env groovy

def call(String PodLabel, code) {
	podTemplate(
		cloud: 'kubernetes-Cluster1'
		label: PodLabel
		containers: [
			containerTemplate(
				name: centos-image
				image: centos:centos7
				command: 'cat'
				ttyEnabled: 'true')
		]) {
		code()
	}
}
