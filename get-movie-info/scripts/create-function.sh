#!/bin/sh
#
# https://docs.aws.amazon.com/ja_jp/lambda/latest/dg/access-control-identity-based.html
#
aws lambda create-function \
	--profile create-lambda \
	--function-name get-movie-info \
	--region ap-northeast-1 \
	--zip-file fileb://get-movie-info/build/libs/get-movie-info-all.jar \
	--role arn:aws:iam::201690154710:role/lambda-exec \
	--handler kazusato.work.serverless.movie.GetMovieInfo::handleRequest \
	--runtime java8 \
	--timeout 30 \
	--memory-size 128
