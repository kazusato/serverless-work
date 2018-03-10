#!/bin/sh
#
# https://docs.aws.amazon.com/ja_jp/lambda/latest/dg/access-control-identity-based.html
#
aws lambda delete-function \
	--profile create-lambda \
	--function-name get-movie-info \
	--region ap-northeast-1 \

