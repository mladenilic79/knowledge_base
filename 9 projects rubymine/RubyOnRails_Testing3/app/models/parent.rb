class Parent < ApplicationRecord

  validates_presence_of :parent_name, :parent_number

  has_many :blogs

  # showcasing nested/nesting elements in view
  # (model/parent controller/parent_controller 2x, views/parents/_form, views/parent/show)
  # accepts_nested_attributes_for :blogs
  # same but with lambda data validation for one attribute
  # accepts_nested_attributes_for :blogs, reject_if: lambda { |attributes| attributes['blog_name'].blank? }
  # same but with basic data validation for two attributes
  accepts_nested_attributes_for :blogs, reject_if: 'blog_name'.blank? or 'blog_number'.blank?

end
