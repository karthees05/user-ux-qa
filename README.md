# user-ux-qa

## Run the End to End UX/UI Tests

#### Run the End to End UI Tests through Cucumber Runner class

Steps to follow:

- Import gradle Dependencies

- Check the BDD Feature files are available in:

```> src/test/resources/features```

- In IDE Go to **src> test> java> RunCuke**

- Right click and Run by setting the below runtime parameter

The Run time parameter needs to be updated based on which environment where we are running.

The following parameters are valid if we run through runner class for local profile
-Dbrowser.type=chrome -Dapp.profile=local -Dapp.uri=http://localhost:3000/


#### Run the End to End UI Tests through gradle task or Pipeline or standalone Jenkins job

The Cucumber tests can be executed along with a stage of this End to End UI Tests in Pipeline or Standalone Jenkins job

From IDE's terminal we can use the below parameters to run End to End UI scenarios.
Template: ./gradle clean cucumber -Dbrowser.type=<browser_type> -Dapp.profile=<local_or_dev> -Dapp.uri=uri
Example: ./gradle clean cucumber -Dbrowser.type=chrome -Dapp.profile=local -Dapp.uri=http://localhost:3000/

Similarly, we can run for other environments by configuring/providing the above 3 parameters in runtime on Pipeline or standalone Jenkins Job.

So this can be integrated easily with CI/CD Pipeline, and it can be executed whenever we want by adding this in a Pipeline stage.
