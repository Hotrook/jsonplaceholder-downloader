# jsonplaceholder-downloader [![Build Status](https://travis-ci.com/Hotrook/jsonplaceholder-downloader.svg?branch=master)](https://travis-ci.com/Hotrook/jsonplaceholder-downloader) [![Maintainability](https://api.codeclimate.com/v1/badges/394a810829fa8366a4c7/maintainability)](https://codeclimate.com/github/Hotrook/jsonplaceholder-downloader/maintainability) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/144377f930d3446a988dff514c7589c3)](https://www.codacy.com/app/Hotrook/jsonplaceholder-downloader?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Hotrook/jsonplaceholder-downloader&amp;utm_campaign=Badge_Grade) [![codecov](https://codecov.io/gh/Hotrook/jsonplaceholder-downloader/branch/master/graph/badge.svg)](https://codecov.io/gh/Hotrook/jsonplaceholder-downloader)

## What is this app? 
This app is designed to download all json posts from `https://jsonplaceholder.typicode.com/posts` and saves every post to different files in given directory.

It takes two parameters: 
* url 
* directory path 

## How to run it? 
Running is very simple: 
```
sbt "run {url} {directoryPath}"
```
for example:
```
sbt "run https://jsonplaceholder.typicode.com/posts posts"
```
It is important that given repository musts exist. 