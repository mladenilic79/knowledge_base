# basic controller
class ApplicationController < ActionController::Base

  include SetSource
  include DefaultPageContent

=begin
  include DeviseWhitelist
  include CurrentUserConcern
=end

end
