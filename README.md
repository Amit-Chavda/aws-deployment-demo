# aws-deployment-demo
> This sample demonstarate how to deploy spring boot app to aws EC2 instance from S3 bucket

### Steps:
   <ol>
        <li>Create a Spring Boot project using Spring Initializr</li>
        <li>Import the project into your favorite IDE</li>
        <li>Add a RestController and test the application locally</li>
        <li>Prepare the final jar file and upload in AWS S3 bucket</li>
        <li>Launch an EC2 Instance and keep the key pair handy</li>
        <li>SSH into the EC2 instance and Install Java 18</li>
        <li>Download jar file and run using `java -jar filename`</li>
        <li>Allow port 8080 on your Instance security group</li>
        <li>Test Your spring boot endpoint deployed on EC2</li>
    </ol>
    
> Note: This steps are common and this project uses Jenkins to perform this steps.

> Info: Every tools, plugins and technology used in this project is listed below.

### Architecture design
![Deploy Spring App in AWS drawio (1)](https://user-images.githubusercontent.com/47694676/187876753-6884f26f-0f77-4697-b73a-3e450b0f5f52.png)

<details>
<summary><h2>Tools used:</h2></summary>

- Java 17
- Spring boot 2.7.2
- AWS CLI 2.7.27
<details>
<summary>Jenkins 2.346.3</summary>

  - SSH Agent
  - Amazon EC2
  - Pipelien: AWS Steps
  - SSH Pipeline Steps
  - CloudBees AWS Credentials
</details>

<details>
<summary>AWS Services</summary>

  - EC2
    - ubuntu
    - security group
    - EBS
  - AWS S3
  - IAM Role
  - VPC
    - Subnets
    - Rout Table
    - Internet Gateway
</details>

</details>


<details>
<summary><h2>Useful Ubuntu Commands</h2></summary>

List of ubuntu commands used by this project

```
//install jdk
sudo apt install openjdk-18-jdk

//set path
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64

//verify
echo $JAVA_HOME

//remove directory
rm -r demo/

//list jvm process
jps

//kill running process by process id
sudo kill pid

//kill a process on running on port 8085
sudo kill $(sudo lsof -t -i:8085)

//connect to ec2 instance
ssh -i aws-ubuntu-server-keypair.pem ubuntu@13.127.76.220

//command conjectives
&&: Run if preceding command exited with 0
;: Run unconditionally
||: Run if preceding command exited with a non-zero exit status.
&: Run both commands in paralell, the first in background and second in foreground.
```
</details>



<details>
<summary><h2>Useful AWS Commands</h2></summary>

List of aws cli commands used by this project

```
//configure aws credentials
aws configure

//list s3 buckets
aws s3 ls

//upload file in s3
aws s3 cp source-path destination-path (i.e. aws s3 cp testfile.txt s3://bucket-name)

//download file
aws s3 cp s3://bucket-name/filename.txt .

```
</details>
