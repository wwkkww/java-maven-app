#!/usr/bin/env groovy
def gv

pipeline {
    agent any
    tools {
      maven 'Maven'
    }
    // parameters {
    //     choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
    //     booleanParam(name: 'executeTests', defaultValue: true, description: '')
    // }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo "Testing the application..."
                    echo "Executing pipeline for branch $BRANCH_NAME"
                }
            }
        }
        stage('build jar') {
            when {
              expression {
                BRANCH_NAME == 'main'
              }
            }
            steps {
                script {
                    echo "Testing the application..."
                    // gv.buildJar()
                }
            }
        }
        // stage('build image') {
        //     steps {
        //         script {
        //             gv.buildImage()
        //         }
        //     }
        // }

        stage('deploy') {
          when {
              expression {
                BRANCH_NAME == 'main'
              }
            }
            steps {
                script {
                    echo "Testing the application with webhook trigger..."
                    // gv.deployApp()
                }
            }
        }
        
    }
}
