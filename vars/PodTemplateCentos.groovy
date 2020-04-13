#!/usr/bin/env groovy

def call(String PodLabel, code) {
	podTemplate(
		cloud: 'kubernetes-Cluster1'
		label: 'general-pod-label-cluster1'
		containers: [
			containerTemplate(
				name: centos-image
				image: centos:centos7
				command: 'cat'
				tty: 'true')
		]) {
		code()
	}
}
