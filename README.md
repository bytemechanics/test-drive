# Copy Commons
[![Latest version](https://maven-badges.herokuapp.com/maven-central/org.bytemechanics/test-drive/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.bytemechanics/test-drive/badge.svg)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=org.bytemechanics%3Atest-drive-parent&metric=alert_status)](https://sonarcloud.io/dashboard/index/org.bytemechanics%3Atest-drive-parent)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=org.bytemechanics%3Atest-drive-parent&metric=coverage)](https://sonarcloud.io/dashboard/index/org.bytemechanics%3Atest-drive-parent)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Pure java testing framework implementation

## Motivation
Spock framework is fantastic but use groovy to test java always will be become a mess. After executing a test that should fail and does not fail. Decided that this must be done in pure java.

## Quick start
(Please read our [Javadoc](https://test-drive.bytemechanics.org/javadoc/index.html) for further information)

1. First of all include the Jar file in your compile and execution classpath.

   **Maven**
   ```xml
   <dependency>
	   <groupId>org.bytemechanics</groupId>
	   <artifactId>test-drive</artifactId>
	   <version>X.X.X</version>
	   <type>test</type>
   </dependency>
   ```

2. In your maven pom.xml activate the surefire test-drive provider by adding the corresponding dependency

   ```xml
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>X.XX.X</version>
				(...)
				<dependencies>
					<dependency>
						<groupId>org.bytemechanics</groupId>
						<artifactId>testdrive-surefire</artifactId>
						<version>X.X.X</version>
					</dependency>
				</dependencies>
			</plugin>
		</plugins>
	</build>
   ```

3. In your maven pom.xml activate the suffix you will use (tipically Spec)

   ```xml
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>X.XX.X</version>
				<configuration>
					<includes>
						<include>*Spec.java</include>
						(...)
					</includes>
				</configuration>
				(...)
			</plugin>
		</plugins>
	</build>
   ```

4. Create your first spec
   * Option 1: non-driven

     ```Java
     import org.bytemechanics.testdrive.Specification;
     import org.bytemechanics.testdrive.annotations.Evaluation;
     import org.bytemechanics.testdrive.annotations.Test;
     import org.bytemechanics.testdrive.Assert;

     public class AddIntegerSpec implements Specification {

        (...)

     	@Test(name="accumulate {} and {} should result with {} with driven test", evaluations = {
     		@Evaluation(name = "one",args = {"1","1","0","2"}),
     		@Evaluation(name = "zero",args = {"0","0","0","0"})
     	})
     	public void accumulate(final int _base,final int _val1,final int _val2,final int _expected){

			int base=_base;
			int actual=base+_val1+_val2;
			Assert.assertEquals(actual,_expected);
     	}
        (...)
     }
     ```

   * Option 2: non-driven with labels

     ```Java
     import org.bytemechanics.testdrive.Specification;
     import org.bytemechanics.testdrive.annotations.Evaluation;
     import org.bytemechanics.testdrive.annotations.Test;
     import org.bytemechanics.testdrive.Assert;

     public class AddIntegerSpec implements Specification {

        (...)

     	@Test(name="accumulate {} and {} should result with {} with driven test", evaluations = {
     		@Evaluation(name = "one",args = {"1","1","0","2"}),
     		@Evaluation(name = "zero",args = {"0","0","0","0"})
     	})
     	public void accumulate(final int _base,final int _val1,final int _val2,final int _expected){

			int base,actual;

			given:
				base=_base;
			when:
				actual=base+_val1+_val2;
			then:
				Assert.assertEquals(actual,_expected);
     	}
        (...)
     }
     ```

   * Option 3: driven

     ```Java
     import org.bytemechanics.testdrive.DrivenTest;
     import org.bytemechanics.testdrive.Specification;
     import org.bytemechanics.testdrive.annotations.Evaluation;
     import org.bytemechanics.testdrive.annotations.Test;
     import org.bytemechanics.testdrive.example.AddInteger;
     import org.bytemechanics.testdrive.exceptions.AssertException;
     import org.bytemechanics.testdrive.Assert;

     public class AddIntegerSpec implements Specification {

        (...)

     	@Test(name="accumulate {} and {} should result with {} with driven test", evaluations = {
     		@Evaluation(name = "one",args = {"1","1","0","2"}),
     		@Evaluation(name = "zero",args = {"0","0","0","0"})
     	})
		public DrivenTest accumulateDriven(final int _base,final int _val1,final int _val2,final int _expected){
			return new DrivenTest() {

				int base,actual;

				@Override
				public void given() {
					this.base=_base;
				}
				@Override
				public void when() {
					this.actual=this.base+_val1+_val2;
				}
				@Override
				public void then() throws AssertException {
					Assert.assertEquals(this.actual,_expected);
				}
			};
		}
        (...)
     }
     ```

For additional information please refer example project
