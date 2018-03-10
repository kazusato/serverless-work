#!/bin/sh
#
# https://docs.aws.amazon.com/ja_jp/lambda/latest/dg/access-control-identity-based.html
#
aws lambda update-function-code \
	--profile create-lambda \
	--function-name get-movie-info \
	--region ap-northeast-1 \
	--zip-file fileb://get-movie-info/build/libs/get-movie-info-all.jar
