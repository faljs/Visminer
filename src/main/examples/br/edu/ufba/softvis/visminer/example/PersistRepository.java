package br.edu.ufba.softvis.visminer.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import br.edu.ufba.softvis.visminer.constant.LanguageType;
import br.edu.ufba.softvis.visminer.constant.MetricUid;
import br.edu.ufba.softvis.visminer.constant.SCMType;
import br.edu.ufba.softvis.visminer.constant.WebSCMType;
import br.edu.ufba.softvis.visminer.main.VisMiner;
import br.edu.ufba.softvis.visminer.model.business.Commit;
import br.edu.ufba.softvis.visminer.model.business.File;
import br.edu.ufba.softvis.visminer.model.business.Repository;
import br.edu.ufba.softvis.visminer.retriever.CommitRetriever;

//This example show how to persist a repository
public class PersistRepository {

	private String repositoryDescription = "Put here repository description";
	private String repositoryName = "Put here repository name";
	private String repositoryOwner = "https://github.com/renatoln/pagseguro-test";
	private String repositoryPath = "C:\\Users\\Gabriel\\Visminer-Test";
	private SCMType repositoryType = SCMType.GIT;
	private WebSCMType repositoryServiceType = WebSCMType.GITHUB;
	private List<MetricUid> metrics = Arrays.asList(MetricUid.SLOC, MetricUid.ATFD, MetricUid.CC, MetricUid.NOCAI, MetricUid.TCC, MetricUid.WMC);
	private List<LanguageType> languages = Arrays.asList(LanguageType.JAVA, LanguageType.NONE);

	public static void main(String[] args){
		
		VisMiner vis = new VisMiner();
		vis.setDBConfig(DatabaseConfig.getDBConfig());
		new PersistRepository().persistRepository();
		
	}

	public void persistRepository(){

		Repository repository = new Repository(0, repositoryDescription, repositoryName, repositoryPath,
				repositoryOwner, repositoryType, repositoryServiceType, "");

		VisMiner vis = new VisMiner();
		try {
			vis.persistRepository(repository, metrics, languages);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getRepositoryDescription() {
		return repositoryDescription;
	}

	public void setRepositoryDescription(String repositoryDescription) {
		this.repositoryDescription = repositoryDescription;
	}

	public String getRepositoryName() {
		return repositoryName;
	}

	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}

	public String getRepositoryPath() {
		return repositoryPath;
	}

	public void setRepositoryPath(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}

	public SCMType getRepositoryType() {
		return repositoryType;
	}

	public void setRepositoryType(SCMType repositoryType) {
		this.repositoryType = repositoryType;
	}

	public String getRepositoryOwner() {
		return repositoryOwner;
	}

	public void setRepositoryOwner(String repositoryOwner) {
		this.repositoryOwner = repositoryOwner;
	}

	public WebSCMType getRepositoryServiceType() {
		return repositoryServiceType;
	}

	public void setRepositoryServiceType(WebSCMType repositoryServiceType) {
		this.repositoryServiceType = repositoryServiceType;
	}

	public List<MetricUid> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<MetricUid> metrics) {
		this.metrics = metrics;
	}

	public List<LanguageType> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguageType> languages) {
		this.languages = languages;
	}

}
