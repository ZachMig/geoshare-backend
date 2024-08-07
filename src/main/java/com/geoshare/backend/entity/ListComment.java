package com.geoshare.backend.entity;


import com.geoshare.backend.parents.Ownable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@Table(name="comment_list")
public class ListComment implements Ownable {
	
	public ListComment(String content, LocationList locationList, GeoshareUser user, ListComment parentComment) {
		this.content = content;
		this.locationList = locationList;
		this.user = user;
		this.parentComment = parentComment;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@Column(name="content", nullable=false)
	private String content;
	
	@ManyToOne
	@JoinColumn(name="list_id", nullable=false)
	private LocationList locationList;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private GeoshareUser user;
	
	@ManyToOne
	@JoinColumn(name="parent_comment_id")
	private ListComment parentComment;

}




