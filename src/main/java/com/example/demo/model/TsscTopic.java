package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.demo.model.TsscGame;
import com.example.demo.Validated.GameValidated;
import com.example.demo.Validated.TopicValidated;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the TSSC_TOPIC database table.
 * 
 */
@Entity
@Table(name = "TSSC_TOPIC")
@NamedQuery(name = "TsscTopic.findAll", query = "SELECT t FROM TsscTopic t")
public class TsscTopic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TSSC_TOPIC_ID_GENERATOR", allocationSize = 1, sequenceName = "TSSC_TOPIC_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TSSC_TOPIC_ID_GENERATOR")
	private long id;

	private String description;

	private String name;
	
	
	@OneToMany(mappedBy = "tsscTopic")
    @JsonIgnore
    private List<TsscTimecontrol> tsscTimecontrols;

	@Min(value = 1, message = "El valor de lo sprints debe ser mayor a 0", groups=TopicValidated.class)
	@Column(name = "DEFAULT_SPRINTS")
	private long defaultSprints;
	@Min(value = 1, message = "El valor de los grupos debe ser mayor a 0", groups=TopicValidated.class)
	@Column(name = "DEFAULT_GROUPS")
	private long defaultGroups;
	@NotBlank(message = "El prefijo no puede estar vac�o", groups=TopicValidated.class)
	@Column(name = "GROUP_PREFIX")
	private String groupPrefix;

	// bi-directional many-to-one association to TsscStory
	@OneToMany(mappedBy = "tsscTopic")
	@JsonIgnore
	private List<TsscGame> tsscGames;

	// bi-directional many-to-one association to TsscStory
	@OneToMany(mappedBy = "tsscTopic")
	@JsonIgnore
	private List<TsscStory> tsscStories;
	
	@OneToMany(mappedBy = "tsscTopic")
	@JsonIgnore
	private List<TsscTimecontrol> tsscTimeControls;

	public List<TsscTimecontrol> getTsscTimecontrols() {
		return tsscTimecontrols;
	}

	public void setTsscTimecontrols(List<TsscTimecontrol> tsscTimecontrols) {
		this.tsscTimecontrols = tsscTimecontrols;
	}

	
	public TsscTopic() {
	     	tsscTimecontrols = new ArrayList<TsscTimecontrol>();
	        tsscStories = new ArrayList<TsscStory>();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDefaultSprints() {
		return defaultSprints;
	}

	public void setDefaultSprints(long defaultSprints) {
		this.defaultSprints = defaultSprints;
	}

	public long getDefaultGroups() {
		return defaultGroups;
	}

	public void setDefaultGroups(long defaultGroups) {
		this.defaultGroups = defaultGroups;
	}

	public String getGroupPrefix() {
		return groupPrefix;
	}

	public void setGroupPrefix(String groupPrefix) {
		this.groupPrefix = groupPrefix;
	}

	public List<TsscStory> getTsscStories() {
		return this.tsscStories;
	}

	public void setTsscStories(List<TsscStory> tsscStories) {
		this.tsscStories = tsscStories;
	}

	public TsscStory addTsscStory(TsscStory tsscStory) {
		getTsscStories().add(tsscStory);
		tsscStory.setTsscTopic(this);

		return tsscStory;
	}

	public TsscStory removeTsscStory(TsscStory tsscStory) {
		getTsscStories().remove(tsscStory);
		tsscStory.setTsscTopic(null);
		return tsscStory;
	}

	public List<TsscTimecontrol> getTsscTimeControls() {
        return this.tsscTimecontrols;
    }

    public void setTsscTimeControls(List<TsscTimecontrol> tsscTimeControls) {
        this.tsscTimecontrols = tsscTimecontrols;
    }
    
	public List<TsscGame> getTsscGames(){
		return this.tsscGames;
	}
	public void setTsscGames(List<TsscGame> tsscGames) {
		this.tsscGames = tsscGames;
	}

    public TsscTimecontrol addTsscTimecontrol(TsscTimecontrol tsscTimecontrol) {
        getTsscTimecontrols().add(tsscTimecontrol);
        tsscTimecontrol.setTsscTopic(this);
        return tsscTimecontrol;
    }
	
	
	


}