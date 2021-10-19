#!/usr/bin/env groovy
def gv

pipeline {
    agent any
    // tools {
    //   maven Maven
    // }
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('build') {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage('test') {
            when {
              expression {
                params.executeTests
              }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage('deploy') {
            input {
              message "Select the environment to deploy..."
              ok "Done"
              parameters {
                choice(name: 'ENV1', choices: ['dev', 'staging', 'prod'], description: '')
                choice(name: 'ENV2', choices: ['dev', 'staging', 'prod'], description: '')
              }
            }
            steps {
                script {
                    gv.deployApp()
                    echo "${ENV1} is selected. Please wait..."
                    echo "${ENV2} is selected. Please wait..."
                    echo "Done"
                }
            }
        }
    }
}
