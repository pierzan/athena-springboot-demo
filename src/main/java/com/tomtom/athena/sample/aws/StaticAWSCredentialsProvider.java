package com.tomtom.athena.sample.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

public class StaticAWSCredentialsProvider implements AWSCredentialsProvider {

    private final AWSCredentials credentials;

    public StaticAWSCredentialsProvider(
        final String awsAccessKey,
        final String awsSecretKey) {
        credentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
    }

    @Override
    public AWSCredentials getCredentials() {
        return credentials;
    }

    @Override
    public void refresh() {
        // NOOP
    }
}
